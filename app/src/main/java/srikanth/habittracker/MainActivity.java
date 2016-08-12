package srikanth.habittracker;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Dbhelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new Dbhelper(this);

        Button btnInsert = (Button) findViewById(R.id.btnInsert);
        Button btnUpdate = (Button) findViewById(R.id.btnUpdate);
        Button btnSelect = (Button) findViewById(R.id.btnSelect);
        Button btnDelete = (Button) findViewById(R.id.btnDelete);
        if (btnInsert != null) {
            btnInsert.setOnClickListener(this);
        }
        if (btnUpdate != null) {
            btnUpdate.setOnClickListener(this);
        }
        if (btnSelect != null) {
            btnSelect.setOnClickListener(this);
        }
        if (btnDelete != null) {
            btnDelete.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnInsert:
                dbHelper.insertRecord(getString(R.string.str_one), getString(R.string.str_number));
                Toast.makeText(MainActivity.this, R.string.str_insert, Toast.LENGTH_LONG).show();
                break;
            case R.id.btnUpdate:
                dbHelper.updateRecord(getString(R.string.str_two), 20000);
                Toast.makeText(MainActivity.this, getString(R.string.str_update) +
                        getString(R.string.str_two) +
                        getString(R.string.str_sal), Toast.LENGTH_LONG).show();
                break;
            case R.id.btnSelect:
                Cursor cursor = dbHelper.selectRecords();
                if (cursor.moveToFirst()) {
                    do {
                        String strName = cursor.getString(cursor.getColumnIndex(ContractClass.DbUser.NAME));
                        String strSalary = cursor.getString(cursor.getColumnIndex(ContractClass.DbUser.SALARY));
                        Toast.makeText(getApplicationContext(), " Name: " + strName + "Salary:" + strSalary, Toast.LENGTH_LONG).show();
                    } while (cursor.moveToNext());
                }
                cursor.close();
                break;
            case R.id.btnDelete:
                dbHelper.deleteRecord();
                Toast.makeText(MainActivity.this, R.string.str_delete, Toast.LENGTH_LONG).show();
        }
    }
}


