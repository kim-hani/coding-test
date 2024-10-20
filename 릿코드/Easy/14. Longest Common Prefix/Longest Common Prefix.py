class Solution(object):
    def longestCommonPrefix(self, strs):
        if not str : return ""
        
        shortest_str = min(strs,key = len)

        for i in range(len(shortest_str)):
            for ohter_str in strs:
                if ohter_str[i] != shortest_str[i]:
                    return shortest_str[:i]

        return shortest_str
