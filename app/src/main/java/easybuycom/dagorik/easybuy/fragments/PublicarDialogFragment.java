package easybuycom.dagorik.easybuy.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import easybuycom.dagorik.easybuy.R;
import easybuycom.dagorik.easybuy.models.PlanNegocio;
import io.realm.Realm;

/**
 * Created by Dagorik on 21/11/16.
 */
public class PublicarDialogFragment extends DialogFragment implements View.OnClickListener {

    private EditText id,objeto,total,iva,months,numeroPagos;
    private Button publicar;

    public PublicarDialogFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_dialog, null);

        id = (EditText) view.findViewById(R.id.id);
        objeto = (EditText) view.findViewById(R.id.objeto);
        total = (EditText) view.findViewById(R.id.total);
        iva = (EditText) view.findViewById(R.id.iva);
        months = (EditText) view.findViewById(R.id.meses);
        numeroPagos = (EditText) view.findViewById(R.id.numeroPagos);
        publicar = (Button) view.findViewById(R.id.BtnPublicar);

        publicar.setOnClickListener(this);
        Log.i("myLog", "hola");
        return view;


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {


            case R.id.BtnPublicar:

                String ids = id.getText().toString();
                String nameProduc = objeto.getText().toString();
                String totale = total.getText().toString();
                Double totalDouble = Double.valueOf(totale);
                String ivas = iva.getText().toString();
                Double ivaDouble = Double.valueOf(ivas);
                int meses = Integer.parseInt(months.getText().toString());
                Double numPagos = Double.valueOf(numeroPagos.getText().toString());

                PlanNegocio planNegocio = new PlanNegocio(ids, nameProduc, totalDouble, ivaDouble, meses, numPagos);
                guardarUsuario(planNegocio);

             break;
        }

    }



    private void guardarUsuario(PlanNegocio planNegocio) {

        Realm.init(getContext());

        // Get a Realm instance for this thread
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        realm.copyToRealmOrUpdate(planNegocio);

        realm.commitTransaction();

        Log.i("myLog", planNegocio.toString());


    }

}
