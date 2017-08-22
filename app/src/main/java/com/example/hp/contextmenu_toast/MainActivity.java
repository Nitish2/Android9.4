package com.example.hp.contextmenu_toast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Creating and initializing Button object
        Button button =(Button)findViewById(R.id.button);
        /*
        registerForContextMenu() method will register all items for a context menu by passing the
        button.
         */
        registerForContextMenu(button);// Creating onClick method
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Long Press", //Toast Message
                        Toast.LENGTH_LONG).show();
            }
        });
    }
    /*
     When the view receives a long-click event, then it calls onCreateContextMenu() method.
     This is where you define the menu items, usually by inflating a menu resource.
     */

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select Action");//Creating menu header
        // Adding items into menu
        menu.add(0,v.getId(),0,"Copy"); //groupId, itemId, order, title
        menu.add(0,v.getId(),0,"Move");
        menu.add(0,v.getId(),0,"Delete");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getTitle() == "Copy") { //if statement when the item tittle equals to Copy
            Toast.makeText(this, "You have clicked "+ item.getTitle(),
                    Toast.LENGTH_LONG).show();//Creating toast message
        } else if (item.getTitle() == "Move") { //if statement when the item tittle equals to Move
            Toast.makeText(this, "You have clicked "+ item.getTitle(),
                    Toast.LENGTH_LONG).show();//Creating toast message
        } else if (item.getTitle() == "Delete") { //if statement when the item tittle equals to Delete
            Toast.makeText(this, "You have clicked "+ item.getTitle(),
                    Toast.LENGTH_LONG).show();//Creating toast message
        } else {
            return false;
        }
        return true;

    }

}
