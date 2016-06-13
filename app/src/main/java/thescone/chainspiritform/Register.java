package thescone.chainspiritform;

/**
 * Created by Habibah on 13-Jun-16.
 */
public class Register {

    private int _id;
    private String _vendorName;
    private String _vendorIC;
    private String _vendorAddress;
    private long _vendorMobile;
    private String _vendorEmail;
    private String _vendorSignInPlatform;

    public Register() {
    }

    public Register(String _vendorName, String _vendorIC, String _vendorAddress, long _vendorMobile, String _vendorEmail, String _vendorSignInPlatform) {
        this._vendorName = _vendorName;
        this._vendorIC = _vendorIC;
        this._vendorAddress = _vendorAddress;
        this._vendorMobile = _vendorMobile;
        this._vendorEmail = _vendorEmail;
        this._vendorSignInPlatform = _vendorSignInPlatform;
    }

    public String get_vendorName() {
        return _vendorName;
    }

    public void set_vendorName(String _vendorName) {
        this._vendorName = _vendorName;
    }

    public String get_vendorIC() {
        return _vendorIC;
    }

    public void set_vendorIC(String _vendorIC) {
        this._vendorIC = _vendorIC;
    }

    public String get_vendorAddress() {
        return _vendorAddress;
    }

    public void set_vendorAddress(String _vendorAddress) {
        this._vendorAddress = _vendorAddress;
    }

    public long get_vendorMobile() {
        return _vendorMobile;
    }

    public void set_vendorMobile(long _vendorMobile) {
        this._vendorMobile = _vendorMobile;
    }

    public String get_vendorEmail() {
        return _vendorEmail;
    }

    public void set_vendorEmail(String _vendorEmail) {
        this._vendorEmail = _vendorEmail;
    }

    public String get_vendorSignInPlatform() {
        return _vendorSignInPlatform;
    }

    public void set_vendorSignInPlatform(String _vendorSignInPlatform) {
        this._vendorSignInPlatform = _vendorSignInPlatform;
    }
}
