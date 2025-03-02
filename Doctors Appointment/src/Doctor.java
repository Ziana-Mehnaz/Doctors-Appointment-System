public class Doctor {
    private String name;
    private String specialty;
    private String[] timeSlots;

    public Doctor(String name, String specialty, String[] timeSlots) {
        this.name = name;
        this.specialty = specialty;
        this.timeSlots = timeSlots;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String[] getTimeSlots() {
        return timeSlots;
    }
}
