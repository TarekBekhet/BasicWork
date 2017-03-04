package company.com.basicwork;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by CW on 27/01/2017.
 */

public class Adapterr extends ArrayAdapter<EmplyeeCustomList> {

    ArrayList<EmplyeeCustomList> empp;
    Activity c;

    public Adapterr(Activity c, ArrayList<EmplyeeCustomList> empp) {

//        el method dea kda esmaha constructor bta5od el array mn el main class w twz3o fl list
        super(c, R.layout.custom_list, empp);
        this.empp = empp;
        this.c = c;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(c);// c.getLayoutInflater();
//el method dea hya ely b3d ma b3tna el data bt2ol dea mkanha dea
        v = inflater.inflate(R.layout.custom_list, parent, false);
//        hna el 7ta ely  lazm t2olo find view by id bl V
        TextView text1 = (TextView) v.findViewById(R.id.text);
        ImageView sora = (ImageView) v.findViewById(R.id.mgls);
        text1.setText(empp.get(position).name);
        EmplyeeCustomList empitem= empp.get(position);
        String photo1= empitem.getPhoto();
        Picasso.with(c).load(photo1).into(sora);

        //sora.setImageResource(empp.get(position).photo);
        return v;
    }
}
