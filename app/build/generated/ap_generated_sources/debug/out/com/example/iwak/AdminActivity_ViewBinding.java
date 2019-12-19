// Generated code from Butter Knife. Do not modify!
package com.example.iwak;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AdminActivity_ViewBinding implements Unbinder {
  private AdminActivity target;

  @UiThread
  public AdminActivity_ViewBinding(AdminActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AdminActivity_ViewBinding(AdminActivity target, View source) {
    this.target = target;

    target.etTitle = Utils.findRequiredViewAsType(source, R.id.et_title, "field 'etTitle'", EditText.class);
    target.etSoal = Utils.findRequiredViewAsType(source, R.id.et_soal, "field 'etSoal'", EditText.class);
    target.etPilihanA = Utils.findRequiredViewAsType(source, R.id.et_pilihanA, "field 'etPilihanA'", EditText.class);
    target.etPilihanB = Utils.findRequiredViewAsType(source, R.id.et_pilihanB, "field 'etPilihanB'", EditText.class);
    target.etPilihanC = Utils.findRequiredViewAsType(source, R.id.et_pilihanC, "field 'etPilihanC'", EditText.class);
    target.etPilihanD = Utils.findRequiredViewAsType(source, R.id.et_pilihanD, "field 'etPilihanD'", EditText.class);
    target.etJawaban = Utils.findRequiredViewAsType(source, R.id.et_jawaban, "field 'etJawaban'", EditText.class);
    target.etIkan = Utils.findRequiredViewAsType(source, R.id.et_ikan, "field 'etIkan'", EditText.class);
    target.etStage = Utils.findRequiredViewAsType(source, R.id.et_stage, "field 'etStage'", EditText.class);
    target.btn = Utils.findRequiredViewAsType(source, R.id.btn, "field 'btn'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AdminActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etTitle = null;
    target.etSoal = null;
    target.etPilihanA = null;
    target.etPilihanB = null;
    target.etPilihanC = null;
    target.etPilihanD = null;
    target.etJawaban = null;
    target.etIkan = null;
    target.etStage = null;
    target.btn = null;
  }
}
