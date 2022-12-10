package com.example.qrcodenew;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class MainActivity extends AppCompatActivity {
    private AppCompatButton btnScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnScan = findViewById(R.id.btn_scan);

        btnScan.setOnClickListener(v->{
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != (PackageManager.PERMISSION_GRANTED)){
                    if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.CAMERA)){
                            scanCode();
                    }else {
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, 0); // request code ini akan tampil di
                        // method onRequestPermissionsResult dalam variable requestQode
                    }
                }else{
                    scanCode();
                }

        });
    }

    private void scanCode() {
        ScanOptions opsi = new ScanOptions();
        opsi.setPrompt("Tombol Volume Atas Untuk Flash");
        opsi.setBeepEnabled(true);
        opsi.setOrientationLocked(true);
        opsi.setCaptureActivity(CaptureAct.class);
        launcher.launch(opsi);


    }
    ActivityResultLauncher<ScanOptions> launcher = registerForActivityResult(new ScanContract(), result -> {
        if (result.getContents() != null){
            TextView tvHasil = findViewById(R.id.tvhasi2);
            tvHasil.setText(result.getContents());
            Intent it = new Intent(getApplicationContext(), ResultActivity.class);
            it.putExtra("result", result.getContents());
            startActivity(it);
            finish();

//            setResult(RESULT_OK, i);
//            finish();
//            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//            builder.setTitle("QR Scan Result");
//            builder.setMessage(result.getContents());
//            Log.d("setkknop : ", result.getContents().toString());
//            builder.setPositiveButton("oke", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    dialogInterface.dismiss();
//                }
//            }).show();
        }
    });
}