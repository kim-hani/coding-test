class Solution(object):
    def isPalindrome(self, x):
      # 음수는 팰린드롬이 될 수 없다.
        if x<0 : 
            return False
      # 0으로 끝나도 대칭이 되지 않음
        if x % 10 == 0 and x != 0 : 
            return False

        reversed_num = 0 
        original = x

      # 정수를 문자열 변환없이 그대로 뒤집는다.
        while x > 0 :
            reversed_num = reversed_num*10 + x % 10
            x //= 10
      # 뒤집어진 정수를 원래 정수와 비교
        return reversed_num == original

        
        
        
