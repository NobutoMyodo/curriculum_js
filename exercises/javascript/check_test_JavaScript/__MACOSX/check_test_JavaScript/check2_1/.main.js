document.addEventListener('DOMContentLoaded', function() {
    // addTodoBtnの要素を取得してください。
    const addTodoBtn = document.getElementById('addTodoBtn');
    const todoInput = document.getElementById('todoInput');
    const todoList = document.getElementById('todoList');

    // 追加ボタンが押下されたときのイベントを追加してください
    addTodoBtn.addEventListener('click', function() {
        if (todoInput.value.trim() === '') {
            alert('ToDoを入力してください');
            return;
        }
        // 処理1、inputが空になっていたら、alert()処理をして処理を終わらせてください。
        // 処理2、todoItem内に入力された文字が追加されるようにしてください。
        const todoItemText = todoInput.value;
        
        // ToDoアイテムのリストアイテムを作成
        const todoItem = document.createElement('li');
        todoItem.className = 'todo-item';
        todoItem.textContent = todoItemText;

        // 削除ボタンを作成
        const deleteBtn = document.createElement('button');
        deleteBtn.textContent = '削除';
        deleteBtn.addEventListener('click', function() {
            todoItem.remove();
        });

        // リストアイテムに削除ボタンを追加
        todoItem.appendChild(deleteBtn);
        
        // ToDoリストに新しいアイテムを追加
        todoList.appendChild(todoItem);

        // 入力フィールドをクリア
        todoInput.value = '';
    });
});