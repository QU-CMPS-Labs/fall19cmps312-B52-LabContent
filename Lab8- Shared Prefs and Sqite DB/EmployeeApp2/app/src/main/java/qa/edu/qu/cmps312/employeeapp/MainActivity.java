package qa.edu.qu.cmps312.employeeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import qa.edu.qu.cmps312.employeeapp.fragment.AddEmployeeDialog;
import qa.edu.qu.cmps312.employeeapp.fragment.DeleteEmployeeDialog;
import qa.edu.qu.cmps312.employeeapp.fragment.SearchEmployeeDialog;
import qa.edu.qu.cmps312.employeeapp.model.Employee;

public class MainActivity extends AppCompatActivity implements AddEmployeeDialog.DialogInterationInerface,
        DeleteEmployeeDialog.DialogInteractionInterface, SearchEmployeeDialog.DialogInteractionInterface {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView resultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = findViewById(R.id.result_tv);
    }

    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.add_btn:

                AddEmployeeDialog dialogFragment = new AddEmployeeDialog();
                dialogFragment.show(getSupportFragmentManager(), "Add_Dialog_Fragment");
                break;
            case R.id.update_btn:
                Toast.makeText(this, "update", Toast.LENGTH_SHORT).show();

                break;
            case R.id.delete_btn:
                DeleteEmployeeDialog deleteDialog = new DeleteEmployeeDialog();
                deleteDialog.show(getSupportFragmentManager(), "Delete_Dialog_Fragment");
                Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();

                break;
            case R.id.search_btn:
                SearchEmployeeDialog searchDialog = new SearchEmployeeDialog();
                searchDialog.show(getSupportFragmentManager(), "Search_Dialog_Fragment");
                Toast.makeText(this, "search", Toast.LENGTH_SHORT).show();

                break;
            case R.id.getAll_btn:
                Toast.makeText(this, "get all", Toast.LENGTH_SHORT).show();

                break;

        }
    }


    @Override
    public void addEmployee(Employee employee) {
        resultTv.setText("\t\t\tEmployee to be added\n\n\nEmployee ID : " + employee.getEmpId() + "\nEmployee Name : " + employee.getName());
        Log.d(TAG, "addEmployee: " + employee.getName());
    }

    @Override
    public void deleteEmployee(int employeeId) {
        resultTv.setText("\t\t\tEmployee to be deleted\n\n\nEmployee ID : " + employeeId);
        Log.d(TAG, "addEmployee: " + employeeId);
    }

    @Override
    public void searchEmployee(int employeeId) {
        resultTv.setText("\t\t\tEmployee to be searched\n\n\nEmployee ID : " + employeeId);
    }
}
