

class Solution {

    // Encode a list of strings to a single string
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            // Store length + delimiter + string
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // Decode a single string back to a list of strings
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            // Find the delimiter (#) to extract length
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            // Extract the string using the length
            String s = str.substring(j + 1, j + 1 + length);
            result.add(s);
            // Move pointer forward
            i = j + 1 + length;
        }
        return result;
    }
}