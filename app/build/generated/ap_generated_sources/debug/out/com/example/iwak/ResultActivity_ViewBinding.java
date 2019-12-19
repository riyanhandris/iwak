// Generated code from Butter Knife. Do not modify!
package com.example.iwak;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ResultActivity_ViewBinding implements Unbinder {
  private ResultActivity target;

  @UiThread
  public ResultActivity_ViewBinding(ResultActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ResultActivity_ViewBinding(ResultActivity target, View source) {
    this.target = target;

    target.tvStage = Utils.findRequiredViewAsType(source, R.id.tv_stage, "field 'tvStage'", TextView.class);
    target.benar1 = Utils.findRequiredViewAsType(source, R.id.benar1, "field 'benar1'", ImageView.class);
    target.benar2 = Utils.findRequiredViewAsType(source, R.id.benar2, "field 'benar2'", ImageView.class);
    target.benar3 = Utils.findRequiredViewAsType(source, R.id.benar3, "field 'benar3'", ImageView.class);
    target.benar4 = Utils.findRequiredViewAsType(source, R.id.benar4, "field 'benar4'", ImageView.class);
    target.benar5 = Utils.findRequiredViewAsType(source, R.id.benar5, "field 'benar5'", ImageView.class);
    target.salah1 = Utils.findRequiredViewAsType(source, R.id.salah1, "field 'salah1'", ImageView.class);
    target.salah2 = Utils.findRequiredViewAsType(source, R.id.salah2, "field 'salah2'", ImageView.class);
    target.salah3 = Utils.findRequiredViewAsType(source, R.id.salah3, "field 'salah3'", ImageView.class);
    target.salah4 = Utils.findRequiredViewAsType(source, R.id.salah4, "field 'salah4'", ImageView.class);
    target.salah5 = Utils.findRequiredViewAsType(source, R.id.salah5, "field 'salah5'", ImageView.class);
    target.btnLanjutkan = Utils.findRequiredViewAsType(source, R.id.btn_lanjutkan, "field 'btnLanjutkan'", Button.class);
    target.btnKeluar = Utils.findRequiredViewAsType(source, R.id.btn_keluar, "field 'btnKeluar'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ResultActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvStage = null;
    target.benar1 = null;
    target.benar2 = null;
    target.benar3 = null;
    target.benar4 = null;
    target.benar5 = null;
    target.salah1 = null;
    target.salah2 = null;
    target.salah3 = null;
    target.salah4 = null;
    target.salah5 = null;
    target.btnLanjutkan = null;
    target.btnKeluar = null;
  }
}
