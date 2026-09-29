class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // We need to find whether ANY permutation of s1 exists as a substring
        // inside s2.
        //
        // Key observation:
        // A permutation has the SAME character frequencies as s1.
        //
        // Example:
        // s1 = "ab"
        // Permutations = "ab", "ba"
        // Both have: a -> 1, b -> 1
        //
        // Therefore, instead of generating permutations, we compare
        // character frequencies using a sliding window.

        // Edge case:
        // A valid permutation of s1 cannot fit inside s2
        // if s2 is shorter than s1.
        if(s2.length() < s1.length())
        {
            return false;
        }

        // freq1 -> frequency of each character in s1
        // freq2 -> frequency of characters in the current window of s2
        //
        // Since the problem contains lowercase English letters,
        // we only need an array of size 26.
        //
        // Index mapping:
        // 'a' - 'a' = 0
        // 'b' - 'a' = 1
        // ...
        // 'z' - 'a' = 25
        int freq1[] = new int[26];
        int freq2[] = new int[26];

        // Initially create a window in s2 having the SAME SIZE as s1.
        //
        // Example:
        // s1 = "ab"
        // s2 = "eidbaooo"
        //
        // Initial window = "ei"
        //
        // We compare the frequency of "ab" with the frequency of "ei".
        for(int i = 0; i < s1.length(); i++)
        {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        // 'matches' tells us how many of the 26 characters
        // have EXACTLY the same frequency in both arrays.
        //
        // If matches == 26:
        //     freq1 and freq2 are completely identical
        //     -> current window is a permutation of s1
        //
        // Example:
        // freq1: a=1, b=1
        // freq2: b=1, a=1
        //
        // All 26 frequencies match (including frequencies of 0).
        int matches = 0;

        for(int i = 0; i < 26; i++)
        {
            if(freq1[i] == freq2[i])
            {
                matches++;
            }
        }

        // 'l' represents the LEFT boundary of our sliding window.
        int l = 0;

        // Start 'r' from s1.length() because the first window
        // has already been created above.
        //
        // Every iteration:
        // 1. Add s2[r] -> expand window from the right.
        // 2. Remove s2[l] -> move window forward from the left.
        //
        // This keeps the window size equal to s1.length().
        for(int r = s1.length(); r < s2.length(); r++)
        {
            // Check the current window BEFORE modifying it.
            //
            // If all 26 character frequencies match,
            // current window is a permutation of s1.
            if(matches == 26)
            {
                return true;
            }

            // ---------------------------------------------------------
            // STEP 1: ADD the new character from the RIGHT
            // ---------------------------------------------------------

            int index = s2.charAt(r) - 'a';

            // Add the new character to the current window's frequency.
            freq2[index]++;

            // If after adding the character, its frequency becomes
            // equal to freq1, we gained one matching character.
            //
            // Example:
            // freq1['a'] = 2
            // freq2['a'] = 1
            //
            // After adding 'a':
            // freq2['a'] = 2
            //
            // So this character now matches.
            if(freq1[index] == freq2[index])
            {
                matches++;
            }

            // If freq2 was previously equal to freq1 and we add
            // another occurrence, we break the match.
            //
            // Example:
            // freq1['a'] = 2
            // freq2['a'] = 2
            //
            // After adding 'a':
            // freq2['a'] = 3
            //
            // So 'a' is no longer matching.
            else if(freq1[index] + 1 == freq2[index])
            {
                matches--;
            }

            // ---------------------------------------------------------
            // STEP 2: REMOVE the character from the LEFT
            // ---------------------------------------------------------

            index = s2.charAt(l) - 'a';

            // Remove the leftmost character because the window
            // must remain exactly s1.length() characters long.
            freq2[index]--;

            // If removing the character makes its frequency
            // equal to freq1, we gained one matching character.
            //
            // Example:
            // freq1['a'] = 2
            // freq2['a'] = 3
            //
            // After removing 'a':
            // freq2['a'] = 2
            //
            // Now it matches.
            if(freq1[index] == freq2[index])
            {
                matches++;
            }

            // If freq2 was equal to freq1 before removing the character,
            // removing it makes the frequencies different.
            //
            // Example:
            // freq1['a'] = 2
            // freq2['a'] = 2
            //
            // After removing 'a':
            // freq2['a'] = 1
            //
            // So we lose one matching character.
            else if(freq1[index] - 1 == freq2[index])
            {
                matches--;
            }

            // Move the left pointer forward.
            // The next window starts from the next character.
            l++;
        }

        // The loop checks matches BEFORE adding/removing characters.
        // Therefore, the final window has not been checked inside
        // the loop yet.
        //
        // If all 26 frequencies match, the final window is a
        // permutation of s1.
        return matches == 26;
    }
}