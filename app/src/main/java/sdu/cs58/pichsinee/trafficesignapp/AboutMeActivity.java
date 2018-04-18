package sdu.cs58.pichsinee.trafficesignapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AboutMeActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

    }//end AboutMeActivity

    public void clickBack(View view) {
        finish();
    }//end clickBack method

    public void PlaySound(View view) {
        if (mediaPlayer != null){//ตรวจสอบว่า obj. mediaPlayer เล่นอยู่หรือเปล่า
            mediaPlayer.stop();// ถ้ามีให้หยุดเล่น
            mediaPlayer.release();//คืน resource ที่ mediaplayer
        }
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.sound);
        mediaPlayer.start();
    }//end PlaySound method

    public void clickFacebook(View view) {
        Intent fbIntent = new Intent(Intent.ACTION_VIEW);
        fbIntent.setData(Uri.parse("https://www.facebook.com/deaw.deddeaw"));
        startActivity(fbIntent);
    }//end clickFacebook method

    public void clickMobile(View view) {
        Intent mobileIntent = new Intent(Intent.ACTION_DIAL);
        mobileIntent.setData(Uri.parse("tel:0948577771"));
        startActivity(mobileIntent);
    }//end clickMobile method

    public void clickMap(View view) {
        String lat = "13.776056";
        String lng = "100.510698";
        String label = "มหาวิทยาลัยสวนดุสิต";

        Uri location = Uri.parse("http://maps.google.com/maps?z=10&q=loc:" + lat + "," + lng + "(" + label + ")");

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        //mapIntent.setPackage("com.google.android,apps,maps");//กำหนดว่าให้เข้า Package ที่เรากำหนด ; ถ้าใช้เทสบนจินนี่โมชั่นไมไ่ด้
        startActivity(mapIntent);
    }//end clickmap method
}//end Class
