package bytom.io.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import bytom.io.R;

public class CreateWalletActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_create_wallet);
        init();
    }
    private void init(){
        findViewById(R.id.iv_left).setOnClickListener(listener);
        ((TextView)findViewById(R.id.tv_title)).setText(getString(R.string.add_wallet));
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };

}
