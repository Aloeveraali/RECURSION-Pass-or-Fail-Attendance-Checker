package LAB2;
public class PassOrFail{

    public static void main(String[] args) {
        // Examples provided
        checkAndPrintResult("PPALLP"); // Expected: PASS
        
    }

    private static void checkAndPrintResult(String record) {
        /*rints the attendance record followed by a dash and the result ("PASS" or "FAIL"). 
        It calls the passOrFailIterative method with the attendance record, and based on the 
        boolean return value it selects "PASS" or "FAIL" to match with the record for output. */
        System.out.println(record + " - " + (passOrFailIterative(record) ? "PASS" : "FAIL"));
    }

    public static boolean passOrFailIterative(String record) {
        int absences = 0;
        int lateStreak = 0;

        /*Starts a loop that iterates over each character in the record string, 
         the student's attendance.*/
        for (int i = 0; i < record.length(); i++) {

        /*takes th the current character from the attendance record string based on the loop index i. */
            char current = record.charAt(i);

            /*Checks if the current character is 'A' (absent). If so, it increments the absences counter
             resets the lateStreak to 0, and checks if absences are 2 or more to return false, indicating fail */
            if (current == 'A') {
                absences++;
                lateStreak = 0; // Reset late streak
                if (absences >= 2) return false; // Fail due to absences


            /*Checks if the current character is 'L' (late). If so, it increments the lateStreak. 
            If lateStreak reaches 3, it returns false, indicating failure due to being late three
             consecutive times */
            } else if (current == 'L') {
                lateStreak++;
                if (lateStreak >= 3) return false; // Fail due to late streak
            } else { // Assuming 'P' for present
                lateStreak = 0; // Reset late streak
            }
        }
        return true; // Pass if no fail conditions met
        //After finishing the loop without meeting any fail conditions, the method returns true, indicating the student passes
    }
}
