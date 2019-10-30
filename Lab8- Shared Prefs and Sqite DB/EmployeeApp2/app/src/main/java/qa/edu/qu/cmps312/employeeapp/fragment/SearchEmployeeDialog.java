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

public class SearchEmployeeDialog extends DialogFragment {

    private DialogInteractionInterface activity;

    public interface DialogInteractionInterface {
        void searchEmployee(int employeeId);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (!(context instanceof DialogInteractionInterface)) throw new AssertionError();
        this.activity = (DialogInteractionInterface) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.custom_query_dialog, container, false);


        final EditText empIdEdt = rootView.findViewById(R.id.empId_edt);

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
                activity.searchEmployee(Integer.parseInt(empIdEdt.getText().toString()));
                dismiss();
            }
        });

        return rootView;
    }
}
