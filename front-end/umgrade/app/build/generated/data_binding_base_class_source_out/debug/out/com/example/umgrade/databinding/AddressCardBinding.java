// Generated by view binder compiler. Do not edit!
package com.example.umgrade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.umgrade.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AddressCardBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final Button btnAddrChange;

  @NonNull
  public final CardView cvAddr;

  @NonNull
  public final EditText edtAddress;

  @NonNull
  public final Guideline guideline21;

  @NonNull
  public final Guideline guideline22;

  @NonNull
  public final TextView tvAddress;

  @NonNull
  public final TextView tvAddressTitle;

  private AddressCardBinding(@NonNull CardView rootView, @NonNull Button btnAddrChange,
      @NonNull CardView cvAddr, @NonNull EditText edtAddress, @NonNull Guideline guideline21,
      @NonNull Guideline guideline22, @NonNull TextView tvAddress,
      @NonNull TextView tvAddressTitle) {
    this.rootView = rootView;
    this.btnAddrChange = btnAddrChange;
    this.cvAddr = cvAddr;
    this.edtAddress = edtAddress;
    this.guideline21 = guideline21;
    this.guideline22 = guideline22;
    this.tvAddress = tvAddress;
    this.tvAddressTitle = tvAddressTitle;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static AddressCardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AddressCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.address_card, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AddressCardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnAddrChange;
      Button btnAddrChange = ViewBindings.findChildViewById(rootView, id);
      if (btnAddrChange == null) {
        break missingId;
      }

      CardView cvAddr = (CardView) rootView;

      id = R.id.edtAddress;
      EditText edtAddress = ViewBindings.findChildViewById(rootView, id);
      if (edtAddress == null) {
        break missingId;
      }

      id = R.id.guideline21;
      Guideline guideline21 = ViewBindings.findChildViewById(rootView, id);
      if (guideline21 == null) {
        break missingId;
      }

      id = R.id.guideline22;
      Guideline guideline22 = ViewBindings.findChildViewById(rootView, id);
      if (guideline22 == null) {
        break missingId;
      }

      id = R.id.tvAddress;
      TextView tvAddress = ViewBindings.findChildViewById(rootView, id);
      if (tvAddress == null) {
        break missingId;
      }

      id = R.id.tvAddressTitle;
      TextView tvAddressTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvAddressTitle == null) {
        break missingId;
      }

      return new AddressCardBinding((CardView) rootView, btnAddrChange, cvAddr, edtAddress,
          guideline21, guideline22, tvAddress, tvAddressTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
