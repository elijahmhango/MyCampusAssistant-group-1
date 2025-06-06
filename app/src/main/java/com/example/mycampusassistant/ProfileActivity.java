java
public class ProfileActivity extends AppCompatActivity {
    private EditText etName, etId, etCourse;
    private Button btnEdit, btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        etName = findViewById(R.id.et_name);
        etId = findViewById(R.id.et_id);
        etCourse = findViewById(R.id.et_course);
        btnEdit = findViewById(R.id.btn_edit);
        btnSave = findViewById(R.id.btn_save);

        // Disable EditTexts initially
        setEditTextEnabled(false);

        btnEdit.setOnClickListener(v -> setEditTextEnabled(true));
        btnSave.setOnClickListener(v -> {
            setEditTextEnabled(false);
            Toast.makeText(this, "Profile saved", Toast.LENGTH_SHORT).show();
        });
    }

    private void setEditTextEnabled(boolean enabled) {
        etName.setEnabled(enabled);
        etId.setEnabled(enabled);
        etCourse.setEnabled(enabled);
    }
}

