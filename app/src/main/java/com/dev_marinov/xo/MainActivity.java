package com.dev_marinov.xo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.internal.Util;



public class MainActivity extends AppCompatActivity{

    LinearLayout ll_frag_main, ll_frag_theme, ll_frag_statistica;

    clWS clws = new clWS();
    Context context;
    int flag_connect = 0;

    SharedPreferences sharedPreferences;

    String value_theme;
    Timer tim;

    public String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i=0; i<messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

          final Window window = getWindow();
          Drawable drawable = getResources().getDrawable(R.drawable.gradient_background);
          window.setStatusBarColor(getResources().getColor(android.R.color.transparent));
           window.setBackgroundDrawable(drawable);
          window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });




//Для получения ID



            String android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
            String deviceId = md5(android_id).toUpperCase();


        new RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("7E9F0207DCD1C0A2F21EC64357E62286"));
        AdView mAdView = findViewById(R.id.adView);                 // 5DECD8E1E548505D79A7798D8E5ACEA8
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("7E9F0207DCD1C0A2F21EC64357E62286").build();
        mAdView.loadAd(adRequest);
        boolean isTestDevice = adRequest.isTestDevice(this);

        Log.e("ID!!", "is Admob Test Device ? "+deviceId+" "+isTestDevice); //to confirm it worked
      //  mAdView.addTestDevice("5DECD8E1E548505D79A7798D8E5ACEA8").build();
        mAdView.loadAd(adRequest);

        FragmentManager fragmentManager = getSupportFragmentManager(); // получение доступа ко всем фрагментам
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); // начать транзакцию
        FragmentMain fragmentMain = new FragmentMain(); // создание fragmentMain экземпляра класса FragmentMain
        fragmentTransaction.replace(R.id.ll_frag_main, fragmentMain); // заменяет в лин лэйауте фрагмент
        fragmentTransaction.commitNow(); // синхронное сохранение



///  addTestDevice -
        // f6c15b03354344d0bd4df096b63728ea - уникальный номер рекламы приложения. после установки google ads можно узнать этот номер






      //  clws.ConnectSocket(this); // в момент пуска приложения я подклбчаюсь к серверу
        // соедениеие удачно или нет
        clws.setonGetConnect(new clWS.onGetConnect() {
            @Override
            public void onGetConnect(boolean isconnect) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //      Toast.makeText(getApplicationContext(),"connect= "+isconnect,Toast.LENGTH_LONG).show();
                    }
                });
                if (isconnect) {
                    flag_connect = 1;
                    Gson json = new Gson();
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("cmd", "device");
                    hashMap.put("device", Build.MODEL);
                    String json_string = json.toJson(hashMap);
                    clws.send(json_string);
                    //     Log.e("КТО"," clws.setonGetConnect - flag_connect = 1; isconnect " + isconnect);
                } else {
                    flag_connect = 0;
                    //      Log.e("КТО"," clws.setonGetConnect - flag_connect = 0; isconnect " + isconnect);
                }
            }});

        // если есть ссобщение от версера, то срабатывает setonGetMessage
        clws.setonGetMessage(new clWS.onGetMessage() {
            @Override
            public void onGetMessage(String text) {
       // Log.e("КТО"," clws.setonGetMessage String text " + text);

            JSONObject jsonObject_1 = null;
            try {
                jsonObject_1 = new JSONObject(text);
                String cmd = jsonObject_1.getString("cmd");
         //      Log.e("cmd","cmd=" + cmd);

               if (cmd.equals("ping"))
               {
                   Gson json = new Gson();
                   HashMap<String, Object> hashMap = new HashMap<>();
                   hashMap.put("cmd", "pong");
                   String json_string = json.toJson(hashMap);
                   clws.send(json_string);
               }
            } catch (JSONException exception) {
                exception.printStackTrace();
            }

           }});

        context = this; // ЧТО ЭТО ОЗНАЧАЕТ?
      //  clws.ConnectSocket(this);

                tim =  new Timer();
                tim.schedule(new TimerTask() { // ЧТО ЭТО ОЗНАЧАЕТ? Таймер запуска
                @Override
                public void run() {
                    //Looper.prepare();

                        if (flag_connect == 0) {
                            clws.ConnectSocket(context);
                           // cancel();
                        }
                    }
                },1000,1000);


        ll_frag_main = findViewById(R.id.ll_frag_main);
        ll_frag_theme = findViewById(R.id.ll_frag_theme);
        ll_frag_statistica = findViewById(R.id.ll_frag_statistica);
    }

    // сервер сообщений
        public void ready_msg_server(final String msg) {
            runOnUiThread(new Runnable() {
                 @Override
               public void run() {
          //      Log.e("ready_msg_server=","ready_msg_server=" + msg);
                    FragmentManager fragmentManager = getSupportFragmentManager(); // получение доступа ко всем фрагментам
                    FragmentMain fragmentMain  = (FragmentMain) fragmentManager.findFragmentById(R.id.ll_frag_main);
                    if (fragmentMain !=null) {
                        fragmentMain.ready_msg_server(msg);
                   }
               }
           });
    }


//////////////////////////////
    // Пробелма испралена. Сейас просиходит передача через интерфейс выбора темы после нажатия во FragmentTheme.
    protected OnBackPressedListener onBackPressedListener;
    public interface OnBackPressedListener {
        void doBack();
    }
    public void setOnBackPressedListener(OnBackPressedListener onBackPressedListener) {
        this.onBackPressedListener = onBackPressedListener;
    }
    @Override
    public void onBackPressed() {
        if (onBackPressedListener != null) {
            onBackPressedListener.doBack();
        }
        else
            select_theme();
            super.onBackPressed();
    }
    @Override
    protected void onDestroy() {
        onBackPressedListener = null;
        super.onDestroy();
    }
///////////////////////////////////////////

    public void select_theme() {
        value_theme = loadSettingString("i_choose_this_theme", "0");
        saveSettingString("i_choose_this_theme", value_theme);
    }

    // считывает файл
    public String loadSettingString(String key, String default_value) {
        sharedPreferences = getSharedPreferences("myPref", MODE_PRIVATE);
        return sharedPreferences.getString(key, default_value);
    }

    // сохраняет в файл
    public void saveSettingString(String key, String value) {
        sharedPreferences = getSharedPreferences("myPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sharedPreferences.edit(); // edit() - редактирование файлов
        ed.putString(key, value); // добавляем ключ и его значение
        if (ed.commit()) // сохранить файл
        {
            //успешно записано данные в файл
        }
        else
        {
            //ошибка при записи
            Toast.makeText(this, "Write error", Toast.LENGTH_SHORT).show();
        }
    }



}