package shesijie.bawei.com.ssj041701.mvp;

public interface Constantr {
    public interface IView{
        void getPresenter(String data);
    }
    public interface IPresenter{
        void onAttch(IView iView);
        void onDeach();
        void Model();
    }
    public interface IModel{
        void show(IModel.ModelCallBack modelCallBack);
        public interface ModelCallBack{
            void onSuccess(String data);
            void onFail();
        }
    }
}
