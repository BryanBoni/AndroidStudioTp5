package com.example.cloud.tp5;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
//write object permet de save des données
    String[] prenoms = new String[]{
            "Bart", "Dark vadrouille", "Luke moonwalker", "Hall 9000", "Loise", "Malcolm",
            "Yugi", "Nameless", "Homer", "Spider cochon", "Jean-Kevin", "Logan",
            "Mathieu Sommet", "Joestophe", "Lucy", "Jaloux", "La Reva", "Emilie",
            "Glados", "Tristan", "IamError", "Eddie Malou", "Willy le jardinier", "Xavier",
            "Côme delome", "la lois rouquette"
    };

    public void drawView(){
        //android.R.layout.simple_list_item_1 est une vue disponible de base dans le SDK android,
        //Contenant une TextView avec comme identifiant "@android:id/text1"
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, prenoms);
        listView.setAdapter(adapter);

        displayMessage(listView);
    }

    public void displayMessage(ListView listView){
        // Create a message handling object as an anonymous class.
        AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // Do something in response to the click
                // 1. Instantiate an AlertDialog.Builder with its constructor
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                // 2. Chain together various setter methods to set the dialog characteristics
                builder.setMessage("it's a reference !")
                        .setTitle("Hey !")
                        .setCancelable(true)
                        .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {

                            }
                        });

                // 3. Get the AlertDialog from create()
                AlertDialog dialog = builder.create();

                dialog.show();
            }
        };

        listView.setOnItemClickListener(mMessageClickedHandler);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawView();
    }
}

