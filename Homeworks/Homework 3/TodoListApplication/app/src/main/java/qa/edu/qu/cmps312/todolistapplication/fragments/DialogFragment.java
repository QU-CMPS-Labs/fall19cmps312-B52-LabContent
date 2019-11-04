package qa.edu.qu.cmps312.todolistapplication.fragments;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import qa.edu.qu.cmps312.todolistapplication.R;
import qa.edu.qu.cmps312.todolistapplication.model.Todo;

/**
 * A simple {@link Fragment} subclass.
 */
public class DialogFragment extends android.support.v4.app.DialogFragment implements View.OnClickListener {

    Todo todo;

    TextView dialogTitleTv;

    EditText titleEdt;

    RadioGroup statusRGB;
    RadioButton doneRB;
    RadioButton notDoneRB;

    RadioGroup priorityRGB;
    RadioButton highRB;
    RadioButton lowRB;
    RadioButton mediumRB;

    Button dateBtn;
    TextView dateTv;

    Button timeBtn;
    TextView timeTv;

    Button cancelBtn;
    Button resetBtn;
    Button submitBtn;


    View view;
    DialogFragmentInteraction interaction;

    public static final String TODO_KEY = "TODO";

    private static boolean isEdit = false;

    public interface DialogFragmentInteraction {
        void addTodo(Todo todo);
        void updateTodo(Todo todo);
        void dismissFragment();
    }


    public DialogFragment() {
        // Required empty public constructor
    }

    //This method is used when we want to add new To-do
    public static DialogFragment newInstance() {

        isEdit = false;    //this is used by the initializeViews method
        Bundle args = new Bundle();

        DialogFragment fragment = new DialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    //This method is used when we want to Edit and exiting To-do
    public static DialogFragment newInstance(Todo todo) {

        isEdit = true;          //this is used by the initializeViews method
        Bundle args = new Bundle();
        args.putParcelable(TODO_KEY, todo);

        DialogFragment fragment = new DialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof DialogFragmentInteraction)) throw new AssertionError();
        interaction = (DialogFragmentInteraction) context;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.custom_dialog, container, false);
    }


    //This method is called after the layout is rendered and you will be able to access the layout by using the rootView object
    @Override
    public void onViewCreated(@NonNull final View rootView, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(rootView, savedInstanceState);
        if (getArguments() != null && isEdit)
            this.todo = getArguments().getParcelable(TODO_KEY);
        else
            this.todo = new Todo();

         /*
         This method gets all the views....just to not overcrowd this method, I extracted all the
         initialization of the views like findViewById to this method...this way our code will stay
         clean
         */

        initializeViews(rootView);

    }

    /*
        This method gets all the ids of the views
        If it is edit it populates data into each view otherwise
        It shows empty dialog with empty views that the user can add too
     */
    public void initializeViews(final View view) {
        this.view = view;
        titleEdt = view.findViewById(R.id.title_edt);
        statusRGB = view.findViewById(R.id.status_rgb);
        priorityRGB = view.findViewById(R.id.priority_rgb);
        dateBtn = view.findViewById(R.id.date_tbn);
        timeBtn = view.findViewById(R.id.time_btn);
        timeTv = view.findViewById(R.id.time_tv);
        dateTv = view.findViewById(R.id.date_tv);
        cancelBtn = view.findViewById(R.id.cancel_btn);
        resetBtn = view.findViewById(R.id.reset_btn);

        dialogTitleTv = view.findViewById(R.id.dialog_title_tv);
        submitBtn = view.findViewById(R.id.submit_btn);

        doneRB = view.findViewById(R.id.done_rb);
        notDoneRB = view.findViewById(R.id.notDone_rb);

        lowRB = view.findViewById(R.id.low_rb);
        mediumRB = view.findViewById(R.id.mid_rb);
        highRB = view.findViewById(R.id.high_rb);


        statusRGB.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rb = view.findViewById(checkedId);
                todo.setStatus(rb.getText().toString());
            }
        });

        priorityRGB.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rb = view.findViewById(checkedId);
                todo.setPriority(rb.getText().toString());
            }
        });

        priorityRGB.setOnClickListener(this);
        dateBtn.setOnClickListener(this);
        timeBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
        resetBtn.setOnClickListener(this);
        submitBtn.setOnClickListener(this);


        //If it an edit then we need to populate the data
        if (isEdit) {
            dialogTitleTv.setText("Edit Todo");
            timeTv.setText(todo.getTime());
            dateTv.setText(todo.getDate());

            //Editing time
            titleEdt.setText(todo.getTitle());

            //Editing time
            if (todo.getStatus().equals("Done"))
                doneRB.setChecked(true);
            else if (todo.getStatus().equals("Not Done"))
                notDoneRB.setChecked(true);

            //Editing time
            if (todo.getPriority().equals("High"))
                highRB.setChecked(true);

            else if (todo.getStatus().equals("Medium"))
                mediumRB.setChecked(true);

            else if (todo.getStatus().equals("Low"))
                lowRB.setChecked(true);
        }


    }

    /*
     ** This is a listener method to all the buttons in the dialog
     */

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.date_tbn:
                new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        todo.setDate(dayOfMonth + "/" + month + "/" + year);
                        dateTv.setText(todo.getDate());
                    }
                }, Calendar.getInstance().get(Calendar.YEAR)
                        , Calendar.getInstance().get(Calendar.MONTH),
                        Calendar.getInstance().get(Calendar.DAY_OF_MONTH)).show();
                break;
            case R.id.time_btn:
                new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String AM_PM;
                        if (hourOfDay < 12) {
                            AM_PM = "AM";
                        } else {
                            AM_PM = "PM";
                        }

                        todo.setTime(hourOfDay + ":" + minute + (minute == 0 ? "0" : "") + " " + AM_PM);
                        timeTv.setText(todo.getTime());

                    }
                }, 0, 0, true).show();
                break;
            case R.id.cancel_btn:
                this.dismiss();
                interaction.dismissFragment();
                break;
            case R.id.reset_btn:
                titleEdt.setText("");
                statusRGB.setOnCheckedChangeListener(null);
                priorityRGB.setOnCheckedChangeListener(null);

                priorityRGB.clearCheck();
                statusRGB.clearCheck();
                dateTv.setText("--/--/--");
                timeTv.setText("00:00:00");
                break;
            case R.id.status_rgb:
                Toast.makeText(getActivity(), "P", Toast.LENGTH_SHORT).show();
                break;
            case R.id.submit_btn:
                todo.setTitle(titleEdt.getText().toString());
                if (validInput()) {
                    if (isEdit)
                        interaction.updateTodo(todo);
                    else
                        interaction.addTodo(todo);
                    this.dismiss();
                } else {
                    Toast.makeText(getActivity(), "Please enter the missing values", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


    public boolean validInput() {
        if (todo.getTitle() != null
                && todo.getDate() != null
                && todo.getTime() != null
                && todo.getPriority() != null
                && todo.getStatus() != null)
            return true;
        return false;
    }
}
