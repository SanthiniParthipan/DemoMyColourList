package sg.edu.rp.c346.id19028654.demomycolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement , etPosition;
    Button btnAdd ,btnR , btnU;
    ListView lvColour;
    ArrayList<String> alColour;
    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etElement=findViewById(R.id.editTextColour);
        btnAdd=findViewById(R.id.buttonAddItem);
        lvColour=findViewById(R.id.listViewColour);
        etPosition=findViewById(R.id.editTextIndex);
        btnR=findViewById(R.id.buttonremove);
        btnU=findViewById(R.id.buttonupdate);

        alColour= new ArrayList<>();
        alColour.add("Red");
        alColour.add("Orange");


        aaColour=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,alColour);

        lvColour.setAdapter(aaColour);



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                //alColour.add(colour);only add color
                int pos =Integer.parseInt((etPosition.getText().toString()));
                alColour.add(pos,colour);
                aaColour.notifyDataSetChanged();



            }
        });
        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Colour=alColour.get(position);
                Toast.makeText(MainActivity.this, "you click " + Colour,
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pos = Integer.parseInt(etPosition.getText().toString());
                alColour.remove(pos);
                aaColour.notifyDataSetChanged();

            }
        });

        btnU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colourNew = etElement.getText().toString();
                int pos = Integer.parseInt(etPosition.getText().toString());
                alColour.set(pos, colourNew);
                aaColour.notifyDataSetChanged();
            }
        });

    }
}
