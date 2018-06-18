package bytom.io;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import bytom.io.my.transaction.activity.TransactionListActivity;

import bytom.io.assetmanage.AssetManagementActivity;

public class BytomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bytom);

        findViewById(R.id.bt_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BytomActivity.this, TransactionListActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.bt_asset_management).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AssetManagementActivity.startActivity(BytomActivity.this);
            }
        });
    }
}