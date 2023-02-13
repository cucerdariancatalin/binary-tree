class Node(var data: Int) {
    var left: Node? = null
    var right: Node? = null
}

class BinaryTree {
    var root: Node? = null

    fun insert(value: Int) {
        root = insertRec(root, value)
    }

    private fun insertRec(node: Node?, value: Int): Node {
        if (node == null) {
            return Node(value)
        }
        if (value < node.data) {
            node.left = insertRec(node.left, value)
        } else if (value > node.data) {
            node.right = insertRec(node.right, value)
        }
        return node
    }

    fun search(value: Int): Boolean {
        return searchRec(root, value)
    }

    private fun searchRec(node: Node?, value: Int): Boolean {
        if (node == null) {
            return false
        }
        if (node.data == value) {
            return true
        }
        return if (value < node.data) {
            searchRec(node.left, value)
        } else {
            searchRec(node.right, value)
        }
    }

    fun inorder() {
        inorderRec(root)
    }

    private fun inorderRec(node: Node?) {
        if (node == null) {
            return
        }
        inorderRec(node.left)
        print("${node.data} ")
        inorderRec(node.right)
    }

    fun preorder() {
        preorderRec(root)
    }

    private fun preorderRec(node: Node?) {
        if (node == null) {
            return
        }
        print("${node.data} ")
        preorderRec(node.left)
        preorderRec(node.right)
    }

    fun postorder() {
        postorderRec(root)
    }

    private fun postorderRec(node: Node?) {
        if (node == null) {
            return
        }
        postorderRec(node.left)
        postorderRec(node.right)
        print("${node.data} ")
    }
}

fun main(args: Array<String>) {
    val bt = BinaryTree()

    // Inserting nodes in the binary tree
    bt.insert(50)
    bt.insert(30)
    bt.insert(20)
    bt.insert(40)
    bt.insert(70)
    bt.insert(60)
    bt.insert(80)

    // Searching for a node in the binary tree
    println("Searching for 20: ${bt.search(20)}")
    println("Searching for 90: ${bt.search(90)}")

    // Traversing the binary tree
    println("Inorder Traversal: ")
    bt.inorder()
    println("\nPreorder Traversal: ")
    bt.preorder()
    println("\nPostorder Traversal: ")
    bt.postorder()
}
