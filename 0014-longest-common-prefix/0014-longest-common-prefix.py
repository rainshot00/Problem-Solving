class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        prefix = strs[0]

        for i in range(len(prefix)):
            c = prefix[i]

            for k in range(1, len(strs)):
                comp_str = strs[k]

                if len(comp_str) == i or comp_str[i] != c:
                    return prefix[:i]
        
        return prefix