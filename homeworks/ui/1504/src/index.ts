type TreeNode<T> = BinaryTreeNode<T> | null;

class BinaryTreeNode<T> {
    public data: T;
    public key: number;
    public left: TreeNode<T>;
    public right: TreeNode<T>;

    public getValue(): T {
        return this.data;
    }

    public getKey(): number {
        return this.key;
    }

    constructor(data: T, key: number) {
        this.data = data;
        this.key  = key;
        
        this.left  = null;
        this.right = null;
    }
}

class BinaryTree<T> {
    private head: TreeNode<T>;

    constructor() {
        this.head = null;
    }

    /*
     * Поиск минимума дерева
     */
    private minimum(root: TreeNode<T>): TreeNode<T> {
        if (root == null) {
            return null;
        }

        return root.left ? this.minimum(root.left) : root;
    }

    /*
     * Поиск максимума дерева
     */
    private maximum(root: TreeNode<T>): TreeNode<T> {
        if (root == null) {
            return null;
        }

        return root.right ? this.maximum(root.right) : root;
    }

    private search(root: TreeNode<T>, key: number): TreeNode<T> {
        if (root == null || key == root.key) {
            return root;
        }

        if (key < root.key) {
            return this.search(root.left, key);
        } else {
            return this.search(root.right, key);
        }
    }

    private myInsertElement(root: TreeNode<T>, data: T, key: number): TreeNode<T> {
        if (root == null) {
            return new BinaryTreeNode(data, key);
        } else {
            if (key < root.key) {   // уходим в левое поддерево
                root.left = this.myInsertElement(root.left, data, key);
            } else {                // уходим в правое поддерево
                root.right = this.myInsertElement(root.right, data, key);
            }

            return root;
        }
    }

    private myDeleteElement(root: TreeNode<T>, key: number): TreeNode<T> {
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = this.myDeleteElement(root.left, key);
        } else if (key > root.key) {
            root.right = this.myDeleteElement(root.right, key);
        } else if (root.left && root.right) {
            let rootKey = this.minimum(root.right);
            root.key = rootKey ? rootKey.key : Number.MIN_VALUE;
            root.right = this.myDeleteElement(root.right, root.key);
        } else {
            if (root.left) {
                root = root.left;
            } else if (root.right) {
                root = root.right;
            } else {
                root = null;
            }
        }

        return root;
    }

    /**
     * Добавление элемента в дерево
     */
    public insertElement(data: T, key: number): void {
        this.head = this.myInsertElement(this.head, data, key);
    }

    /**
     * Удаление элемента с заданным ключом
     */
    public deleteElement(key: number): void {
        this.head = this.myDeleteElement(this.head, key);
    }

    /**
     * Извлечение элемента по ключу
     */
    public searchElement(key: number): T | null {
        let findData = this.search(this.head, key);
        return findData ? findData.data : null;
    }

    /**
     * Вывод всего дерева (I var)
     * Обход узлов в отсортированном порядке
     */
    public inorderTraversal(root: TreeNode<T>): void {
        if (root) {
            this.inorderTraversal(root.left);
            console.log(root.data + " ");
            this.inorderTraversal(root.right);
        }
    }

    /**
     * Вывод всего дерева (II var)
     * Обход узлов в порядке: вершина, левое поддерево, правое поддерево
     */
    public preorderTraversal(root: TreeNode<T>): void {
        if (root) {
            console.log(root.data + " ");
            this.preorderTraversal(root.left);
            this.preorderTraversal(root.right);
        }
    }

    /**
     * Вывод всего дерева (III var)
     * Обход узлов в порядке: левое поддерево, правое поддерево, вершина
     */
    public postorderTraversal(root: TreeNode<T>): void {
        if (root) {
            this.postorderTraversal(root.left);
            this.postorderTraversal(root.right);
            console.log(root.data + " ");
        }
    }

    public printTree(): void {
        console.log("Inorder traversal: ");
        this.inorderTraversal(this.head);
        console.log();
    }
}

// -> main
let tree = new BinaryTree<string>();

function clickInsVal(): void {
    let klue = (<HTMLInputElement>document.getElementById("cellInsKlue")).value;
    let val = (<HTMLInputElement>document.getElementById("cellInsVal")).value;

    tree.insertElement(val, Number(klue));
    console.log("Элемент добавлен " + klue + " " + val);
}

function clickDelVal(): void {
    let klue = (<HTMLInputElement>document.getElementById("cellDelKlue")).value;
    tree.deleteElement(Number(klue));
    console.log("Элемент удален " + klue);
}

function clickFindVal(): void {
    let klue = (<HTMLInputElement>document.getElementById("cellFindKlue")).value;
    console.log(klue);
    console.log(tree.searchElement(Number(klue)));
}

function clickPrintVal(): void {
    tree.printTree();
}

document.getElementById("cellButtonIns")?.setAttribute("onclick", "clickInsVal()");
document.getElementById("cellButtonDel")?.setAttribute("onclick", "clickDelVal()");
document.getElementById("cellButtonFind")?.setAttribute("onclick", "clickFindVal()");
document.getElementById("cellButtonPrint")?.setAttribute("onclick", "clickPrintVal()");

// tree.insertElement("a", 8);
// tree.insertElement("b1", 3);
// tree.insertElement("b2", 10);
// tree.insertElement("c1", 1);
// tree.insertElement("c2", 6);
// tree.insertElement("c4", 14);
// tree.insertElement("d3", 4);
// tree.insertElement("d4", 7);
// tree.insertElement("d5", 13);

// console.log(tree.searchElement(6));

// tree.printTree();
// tree.deleteElement(14);
// tree.printTree();

// tree.insertElement("d1", 0);
// tree.printTree();