package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText firstNameEditText, lastNameEditText, birthdayEditText, addressEditText, emailEditText;
    private RadioGroup genderRadioGroup;
    private RadioButton maleRadioButton, femaleRadioButton;
    private CheckBox agreeCheckBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNameEditText = findViewById(R.id.firstName);
        lastNameEditText = findViewById(R.id.lastName);
        birthdayEditText = findViewById(R.id.birthday);
        addressEditText = findViewById(R.id.address);
        emailEditText = findViewById(R.id.email);
//        genderRadioGroup = findViewById(R.id.gender);
        maleRadioButton = findViewById(R.id.male);
        femaleRadioButton = findViewById(R.id.female);
        agreeCheckBox = findViewById(R.id.terms);
// Thiết lập sự kiện cho nút "Register"
        Button registerButton = findViewById(R.id.register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Kiểm tra xem tất cả trường thông tin đã được nhập đầy đủ hay chưa
                if (isRegistrationValid()) {
                    // Thực hiện đăng ký ở đây (đã xác thực)
                }
            }
        });

        // Thiết lập sự kiện cho EditText Birthday để hiển thị DatePickerDialog
        birthdayEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, selectedYear, selectedMonth, selectedDay) -> {
            // Xử lý ngày tháng đã chọn và cập nhật EditText "birthday"
            String selectedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
            birthdayEditText.setText(selectedDate);
        }, year, month, day);

        datePickerDialog.show();
    }

    private boolean isRegistrationValid() {
        // Kiểm tra các trường thông tin ở đây và trả về true nếu hợp lệ, false nếu không hợp lệ
        // Ví dụ: kiểm tra xem các EditText không rỗng, một trong hai giới tính đã được chọn, và CheckBox đã được chọn
        if (firstNameEditText.getText().toString().isEmpty() || lastNameEditText.getText().toString().isEmpty() ||
                birthdayEditText.getText().toString().isEmpty() || addressEditText.getText().toString().isEmpty() ||
                emailEditText.getText().toString().isEmpty() || (!maleRadioButton.isChecked() && !femaleRadioButton.isChecked()) ||
                !agreeCheckBox.isChecked()) {
            return false;
        }
        return true;
    }
}

