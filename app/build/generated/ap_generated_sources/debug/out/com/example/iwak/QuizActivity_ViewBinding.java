// Generated code from Butter Knife. Do not modify!
package com.example.iwak;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class QuizActivity_ViewBinding implements Unbinder {
  private QuizActivity target;

  private View view7f080054;

  private View view7f08004f;

  private View view7f08004e;

  private View view7f08004d;

  private View view7f08004c;

  private View view7f08009d;

  private View view7f08009e;

  @UiThread
  public QuizActivity_ViewBinding(QuizActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public QuizActivity_ViewBinding(final QuizActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_pilih, "field 'btnPilih' and method 'onViewClicked'");
    target.btnPilih = Utils.castView(view, R.id.btn_pilih, "field 'btnPilih'", Button.class);
    view7f080054 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_d, "field 'btnD' and method 'onViewClicked'");
    target.btnD = Utils.castView(view, R.id.btn_d, "field 'btnD'", Button.class);
    view7f08004f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_c, "field 'btnC' and method 'onViewClicked'");
    target.btnC = Utils.castView(view, R.id.btn_c, "field 'btnC'", Button.class);
    view7f08004e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_b, "field 'btnB' and method 'onViewClicked'");
    target.btnB = Utils.castView(view, R.id.btn_b, "field 'btnB'", Button.class);
    view7f08004d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_a, "field 'btnA' and method 'onViewClicked'");
    target.btnA = Utils.castView(view, R.id.btn_a, "field 'btnA'", Button.class);
    view7f08004c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvSoal = Utils.findRequiredViewAsType(source, R.id.tv_soal, "field 'tvSoal'", TextView.class);
    view = Utils.findRequiredView(source, R.id.iv_benar, "field 'ivBenar' and method 'onViewClicked'");
    target.ivBenar = Utils.castView(view, R.id.iv_benar, "field 'ivBenar'", ImageView.class);
    view7f08009d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_salah, "field 'ivSalah' and method 'onViewClicked'");
    target.ivSalah = Utils.castView(view, R.id.iv_salah, "field 'ivSalah'", ImageView.class);
    view7f08009e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    QuizActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnPilih = null;
    target.btnD = null;
    target.btnC = null;
    target.btnB = null;
    target.btnA = null;
    target.tvSoal = null;
    target.ivBenar = null;
    target.ivSalah = null;

    view7f080054.setOnClickListener(null);
    view7f080054 = null;
    view7f08004f.setOnClickListener(null);
    view7f08004f = null;
    view7f08004e.setOnClickListener(null);
    view7f08004e = null;
    view7f08004d.setOnClickListener(null);
    view7f08004d = null;
    view7f08004c.setOnClickListener(null);
    view7f08004c = null;
    view7f08009d.setOnClickListener(null);
    view7f08009d = null;
    view7f08009e.setOnClickListener(null);
    view7f08009e = null;
  }
}
