"""Count solved Programmers problems in this repo and render progress/programmers.svg.

Two layouts are counted:
  - legacy:       src/main/java/programmers/Lv{n}/{title}.java
  - BaekjoonHub:  프로그래머스/{level}/{id}. {title}/   (level is "2" or "lv2")
The same problem in both layouts is counted once (titles compared without spaces,
after NFKC so BaekjoonHub's full-width "（1）" matches a legacy "(1)").
"""
import re
import sys
import unicodedata
from datetime import datetime, timedelta, timezone
from pathlib import Path
from xml.sax.saxutils import escape

ROOT = Path(sys.argv[1]) if len(sys.argv) > 1 else Path(".")
OUT = ROOT / "progress" / "programmers.svg"
LEVELS = range(0, 6)
LEVEL_COLORS = ["#9ca3af", "#5ed3f3", "#4ade80", "#f8d847", "#fb923c", "#fe428e"]


def normalize(title):
    return re.sub(r"\s+", "", unicodedata.normalize("NFKC", title)).lower()


def level_of(name):
    m = re.search(r"\d+", name)
    return int(m.group()) if m else None


def collect():
    solved = {}  # normalized title -> level

    legacy = ROOT / "src" / "main" / "java" / "programmers"
    if legacy.is_dir():
        for f in legacy.glob("*/*.java"):
            solved.setdefault(normalize(f.stem), level_of(f.parent.name))

    hub = ROOT / "프로그래머스"
    if hub.is_dir():
        for level_dir in (d for d in hub.iterdir() if d.is_dir()):
            for problem in (d for d in level_dir.iterdir() if d.is_dir()):
                title = re.sub(r"^\d+\.\s*", "", problem.name)
                solved.setdefault(normalize(title), level_of(level_dir.name))

    return solved


def render(solved):
    counts = {lv: 0 for lv in LEVELS}
    for lv in solved.values():
        if lv in counts:
            counts[lv] += 1
    total = len(solved)
    peak = max(counts.values()) or 1
    updated = datetime.now(timezone(timedelta(hours=9))).strftime("%Y-%m-%d")

    width, bar_x, bar_w, row_h, top = 495, 70, 340, 22, 92
    height = top + row_h * len(LEVELS) + 30
    rows = []
    for i, lv in enumerate(LEVELS):
        y = top + i * row_h
        w = max(counts[lv] / peak * bar_w, 2 if counts[lv] else 0)
        rows.append(
            f'<text x="25" y="{y + 12}" class="label">Lv.{lv}</text>'
            f'<rect x="{bar_x}" y="{y + 2}" width="{bar_w}" height="12" rx="6" class="track"/>'
            f'<rect x="{bar_x}" y="{y + 2}" width="{w:.1f}" height="12" rx="6" fill="{LEVEL_COLORS[lv]}"/>'
            f'<text x="{bar_x + bar_w + 15}" y="{y + 12}" class="count">{counts[lv]}</text>'
        )

    return f"""<svg xmlns="http://www.w3.org/2000/svg" width="{width}" height="{height}" viewBox="0 0 {width} {height}" role="img" aria-label="Programmers: {total} solved">
<style>
  text {{ font-family: 'Segoe UI', Ubuntu, 'Helvetica Neue', sans-serif; }}
  .title {{ font-size: 18px; font-weight: 600; fill: #fe428e; }}
  .total {{ font-size: 28px; font-weight: 700; fill: #f8d847; }}
  .sub {{ font-size: 13px; fill: #a9fef7; }}
  .label {{ font-size: 13px; font-weight: 600; fill: #a9fef7; }}
  .count {{ font-size: 13px; font-weight: 600; fill: #ffffff; }}
  .track {{ fill: #2a2840; }}
  .foot {{ font-size: 11px; fill: #6b6a80; }}
</style>
<rect x="0.5" y="0.5" width="{width - 1}" height="{height - 1}" rx="4.5" fill="#141321" stroke="#e4e2e2" stroke-opacity="0.2"/>
<text x="25" y="35" class="title">Programmers Progress</text>
<text x="25" y="72" class="total">{total}</text>
<text x="{25 + 18 * len(str(total)) + 8}" y="72" class="sub">problems solved</text>
{"".join(rows)}
<text x="{width - 25}" y="{height - 12}" text-anchor="end" class="foot">updated {escape(updated)} KST</text>
</svg>
"""


if __name__ == "__main__":
    solved = collect()
    OUT.parent.mkdir(parents=True, exist_ok=True)
    OUT.write_text(render(solved), encoding="utf-8")
    print(f"{len(solved)} problems -> {OUT}")
