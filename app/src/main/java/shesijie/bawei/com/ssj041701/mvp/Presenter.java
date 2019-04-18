package shesijie.bawei.com.ssj041701.mvp;

public class Presenter implements Constantr.IPresenter {
    Model model ;
    Constantr.IView iView;
    @Override
    public void onAttch(final Constantr.IView iView) {
        model = new Model ();
        this.iView = iView;
        model.show ( new Constantr.IModel.ModelCallBack () {
            @Override
            public void onSuccess(String data) {
                iView.getPresenter ( data );
            }

            @Override
            public void onFail() {

            }
        } );
    }

    @Override
    public void onDeach() {
        if (iView != null ) {
            iView = null;
        }
        if (model != null) {
            model = null;
        }System.gc ();
    }

    @Override
    public void Model() {

    }
}
