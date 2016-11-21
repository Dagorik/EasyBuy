package easybuycom.dagorik.easybuy.fragments;


import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import easybuycom.dagorik.easybuy.R;
import easybuycom.dagorik.easybuy.models.PlanNegocio;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment implements View.OnClickListener {

    private FloatingActionButton floatingActionButton;

    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);



        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.floatingButtom);
        floatingActionButton.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.floatingButtom:

                showDialog();

                break;
        }
    }

    public void showDialog() {


        android.support.v4.app.FragmentManager fm = getActivity().getSupportFragmentManager();
        PublicarDialogFragment dialogFragment = new PublicarDialogFragment();
        dialogFragment.show(fm,"Publicar" );

    }






}
