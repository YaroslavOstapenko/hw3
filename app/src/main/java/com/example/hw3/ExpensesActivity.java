package com.example.hw3;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ExpensesActivity extends AppCompatActivity {

    private EditText amountInput;
    private CheckBox cbFood, cbTransport, cbFun, cbEdu;
    private RadioGroup paymentMethodGroup;
    private Button saveExpenseButton, btnBackToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        amountInput = findViewById(R.id.amountInput);
        cbFood = findViewById(R.id.cbFood);
        cbTransport = findViewById(R.id.cbTransport);
        cbFun = findViewById(R.id.cbFun);
        cbEdu = findViewById(R.id.cbEdu);
        paymentMethodGroup = findViewById(R.id.radioGroupPayment);
        saveExpenseButton = findViewById(R.id.saveExpense);
        btnBackToMain = findViewById(R.id.btnBackToMain);

        saveExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = amountInput.getText().toString().trim();

                if (amount.isEmpty()) {
                    Toast.makeText(ExpensesActivity.this, "Будь ласка, введіть суму витрат", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuilder categories = new StringBuilder();
                if (cbFood.isChecked()) categories.append("Їжа, ");
                if (cbTransport.isChecked()) categories.append("Транспорт, ");
                if (cbFun.isChecked()) categories.append("Розваги, ");
                if (cbEdu.isChecked()) categories.append("Навчання, ");

                if (categories.length() > 0) {
                    categories.setLength(categories.length() - 2);
                }

                int selectedPaymentId = paymentMethodGroup.getCheckedRadioButtonId();
                RadioButton selectedPaymentMethod = findViewById(selectedPaymentId);
                String paymentMethod = selectedPaymentMethod != null ? selectedPaymentMethod.getText().toString() : "Не вибрано";

                String expenseDetails = "Сума витрат: " + amount + "\nКатегорії: " + categories + "\nСпосіб оплати: " + paymentMethod;
                Toast.makeText(ExpensesActivity.this, "Витрати збережено: " + expenseDetails, Toast.LENGTH_LONG).show();
            }
        });

        btnBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpensesActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
