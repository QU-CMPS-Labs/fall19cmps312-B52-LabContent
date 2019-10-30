package qa.edu.qu.cmps312.employeeapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import qa.edu.qu.cmps312.employeeapp.R;
import qa.edu.qu.cmps312.employeeapp.model.Employee;

public class AddEmployeeDialog extends DialogFragment {

    private DialogInterationInerface activity;

    public interface DialogInterationInerface {
        void addEmployee(Employee employee);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (!(context instanceof DialogInterationInerface)) throw new AssertionError();
        this.activity = (DialogInterationInerface) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.custom_dialog, container, false);


        final EditText empIdEdt = rootView.findViewById(R.id.empId_edt);
        final EditText empNameEdt = rootView.findViewById(R.id.empName_edt);

        Button submitBtn = rootView.findViewById(R.id.submit_btn);
        Button cancelBtn = rootView.findViewById(R.id.cancel_btn);


        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.addEmployee(new Employee(Integer.parseInt(empIdEdt.getText().toString()),
                        empNameEdt.getText().toString()));
                dismiss();
            }
        });

        return rootView;
    }
}
