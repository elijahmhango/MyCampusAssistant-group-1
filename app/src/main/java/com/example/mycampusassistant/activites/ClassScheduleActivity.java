java
public class ClassScheduleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_schedule);

        RecyclerView rvSchedule = findViewById(R.id.rv_schedule);
        rvSchedule.setLayoutManager(new LinearLayoutManager(this));

        List<ClassSchedule> scheduleList = new ArrayList<>();
        scheduleList.add(new ClassSchedule("Mon", "8AM", "Math"));
        scheduleList.add(new ClassSchedule("Tue", "10AM", "Java"));
        // Add more schedules

        ScheduleAdapter adapter = new ScheduleAdapter(scheduleList);
        rvSchedule.setAdapter(adapter);
    }
}
