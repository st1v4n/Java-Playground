package UniversitySystem;

public class FacultyNumberGenerator {
    private static int currentFN = 100000;
    public static int getFacultyNumber(){
        return currentFN++;
    }
}
