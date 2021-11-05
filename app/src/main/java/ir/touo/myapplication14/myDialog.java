package ir.touo.myapplication14;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class myDialog extends DialogFragment {

    View view;
    View add;
    EditText firstName,lastName;
    onAddButtonClick onAddButtonClick;

    public void setOnAddButtonClick(myDialog.onAddButtonClick onAddButtonClick) {
        this.onAddButtonClick = onAddButtonClick;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        view = LayoutInflater.from(getContext()).inflate(R.layout.my_dialog,null);

        alert.setView(view);
        setUpViews();

        return alert.create();
    }

    private void setUpViews() {
        add = view.findViewById(R.id.my_dialog_btn_add);
        firstName = view.findViewById(R.id.edt_dialog_FirstName);
        lastName = view.findViewById(R.id.edt_dialog_lastName);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAddButtonClick.onAddButton(firstName.getText().toString(),lastName.getText().toString());
                dismiss();
            }
        });

    }

       public interface onAddButtonClick{
        void onAddButton(String firstName , String lastName);
    }

}
