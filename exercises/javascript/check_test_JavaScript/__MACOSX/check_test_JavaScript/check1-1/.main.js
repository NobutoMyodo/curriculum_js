// 要件：ユーザーを登録できる機能を作成します。

class User {
    constructor(name,mail){
        this.name=name;
        this.mail=mail;// 名前とメールアドレスのプロパティを持ったコンストラクタを作成してください。
}
}

// ユーザー情報を保存する配列を作成してください。
let users=[];
// ユーザー情報を登録する関数を作成してください。
function registerUser() {
    // nameフィールドの値を取得してください
    // emailフィールドの値を取得してください。
    let nameField = document.getElementById("name").value;
    let mailField = document.getElementById("mail").value;
    
    let newUser=new User(name,mail);
    // 登録されているユーザーを取得してください。
    let name = nameField.value;
    let mail= mailField.value;
    // メールアドレスの重複を確認してください。
    // 既に登録済みの場合、登録しようとしたメールアドレスをを含む重複している旨のメッセージを出力してください。
    // 未登録の場合はユーザー情報を配列に追加してください。    
    // 登録後にnameフィールドの値を削除してください
    nameField.value = "";
    // 登録後にemailフィールドの値を削除してください
    mailField.value= "";
}

// 登録されたユーザー情報を1件ずつコンソール出力する関数を作成してください。
function findUser() {
    for (let i=0; i<users.length; i++) {
        console.log(users[i]);
    }
}