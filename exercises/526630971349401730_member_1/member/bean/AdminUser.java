package member.bean;
class AdminUser extends User{
    public AdminUser(String name, String email, String adminCode) {
        super(name, email);
    }
    @Override
        public String toString(){
            return "管理者ユーザー: 名前"+name+",メールアドレス： "+email;
        }
}

