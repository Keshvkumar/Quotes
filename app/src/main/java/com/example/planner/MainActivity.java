package com.example.planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{

    String quote_txt="";
    TextView quote;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Default TextView for first time app
          is launched. */
        quote=(TextView)findViewById(R.id.quote_view);
        quote.setText(choice());
    }
    private String choice()
    {
        String temp="";

        /*Random integer value to select a random
          code and view this quote in TextView. */
        Random rand = new Random();
        int i = rand.nextInt((15 - 0) + 1) + 0;

        switch(i)
        {
            case 0:
                temp="\"You have brains in your head. You have feet in your shoes. You can steer yourself any direction you choose. You're on your own. And you know what you know. And YOU are the one who'll decide where to go...\"";
                break;
            case 1:
                temp="\"Be who you are and say what you feel, because those who mind don't matter, and those who matter don't mind.\"";
                break;
            case 2:
                temp="\"You've gotta dance like there's nobody watching,\n" +
                        "Love like you'll never be hurt,\n" +
                        "Sing like there's nobody listening,\n" +
                        "And live like it's heaven on earth.\"";
                break;
            case 3:
                temp="\"Be the change that you wish to see in the world.\"";
                break;
            case 4:
                temp="\"Don’t walk in front of me… I may not follow\n" +
                        "Don’t walk behind me… I may not lead\n" +
                        "Walk beside me… just be my friend\"";
                break;
            case 5:
                temp="\"People will forget what you said, people will forget what you did, but people will never forget how you made them feel.\"";
                break;
            case 6:
                temp="\"Darkness cannot drive out darkness: only light can do that. Hate cannot drive out hate: only love can do that.\"";
                break;
            case 7:
                temp="\"To be yourself in a world that is constantly trying to make you something else is the greatest accomplishment.\"";
                break;
            case 8:
                temp="\"It is better to be hated for what you are than to be loved for what you are not.\"";
                break;
            case 9:
                temp="\"Imperfection is beauty, madness is genius and it's better to be absolutely ridiculous than absolutely boring.\"";
                break;
            case 10:
                temp="\"There are only two ways to live your life. One is as though nothing is a miracle. The other is as though everything is a miracle.\"";
                break;
            case 11:
                temp="\"Whatever the mind of man can conceive and believe, it can achieve.\"";
                break;
            case 12:
                temp="\"Strive not to be a success, but rather to be of value.\"";
                break;
            case 13:
                temp="\"Life isn't about getting and having, it's about giving and being.\"";
                break;
            case 14:
                temp="\"The most common way people give up their power is by thinking they don’t have any.\"";
                break;
            case 15:
                temp="\"Every child is an artist.  The problem is how to remain an artist once he grows up.\"";
                break;
            default:
                break;
        }
        quote_txt=temp;
        return temp;
    }

    public void share(View view)
    {
        PackageManager pm=getPackageManager();
        try
        {

            Intent waIntent = new Intent(Intent.ACTION_SEND);
            waIntent.setType("text/plain");
            String text = quote_txt;

            PackageInfo info=pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            /* Check if package exists or not. If not then code
            in catch block will be called */
            waIntent.setPackage("com.whatsapp");

            waIntent.putExtra(Intent.EXTRA_TEXT, text);
            startActivity(Intent.createChooser(waIntent, "Share with"));

        }
        catch (PackageManager.NameNotFoundException e)
        {
            Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT).show();
        }
    }

    public void refresh(View view)
    {
        quote.setText(choice());
    }
}