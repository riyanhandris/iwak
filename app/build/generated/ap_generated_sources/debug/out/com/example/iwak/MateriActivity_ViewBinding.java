// Generated code from Butter Knife. Do not modify!
package com.example.iwak;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MateriActivity_ViewBinding implements Unbinder {
  private MateriActivity target;

  @UiThread
  public MateriActivity_ViewBinding(MateriActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MateriActivity_ViewBinding(MateriActivity target, View source) {
    this.target = target;

    target.title = Utils.findRequiredViewAsType(source, R.id.title, "field 'title'", TextView.class);
    target.materi = Utils.findRequiredViewAsType(source, R.id.materi, "field 'materi'", TextView.class);
    target.btn = Utils.findRequiredViewAsType(source, R.id.btn, "field 'btn'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MateriActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.title = null;
    target.materi = null;
    target.btn = null;
  }
}
