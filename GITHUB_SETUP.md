# GitHub Setup Guide - Tree Problems

## Quick Start: Push to GitHub

### Prerequisites
- Git installed on your machine
- GitHub account
- Repository created on GitHub named `leetcode-tree-problems`

### Step 1: Initialize Git (if not already done)
```bash
cd leetcode-tree-problems
git init
git config user.email "your-email@example.com"
git config user.name "Your Name"
```

### Step 2: Add All Files
```bash
git add .
```

### Step 3: Create Initial Commit
```bash
git commit -m "Initial commit: Tree Problems - 20 solutions with 60+ tests"
```

### Step 4: Add Remote Repository
Replace `YOUR_USERNAME` with your GitHub username:
```bash
git remote add origin https://github.com/YOUR_USERNAME/leetcode-tree-problems.git
```

### Step 5: Push to GitHub
```bash
git branch -M main
git push -u origin main
```

---

## Repository Information

- **Project**: LeetCode Tree Problems
- **Solutions**: 20 complete Java implementations (Easy & Intermediate only)
- **Test Cases**: 60+ (100% pass rate)
- **Categories**: 4 (Basic Operations, Traversal & Construction, Path & Sum, Advanced Patterns)
- **Difficulty**: Easy (10), Medium (10), Hard (0)

---

## What's Included

- ✅ 20 complete Java solutions
- ✅ 60+ test cases
- ✅ TreeNode utility class with helper methods
- ✅ Comprehensive documentation
- ✅ .gitignore for Java projects
- ✅ README with quick start guide

---

## After First Push

### For Future Updates
```bash
git add .
git commit -m "Your commit message"
git push origin main
```

### Clone This Repository
```bash
git clone https://github.com/YOUR_USERNAME/leetcode-tree-problems.git
cd leetcode-tree-problems
javac solutions/java/*.java
java -cp solutions/java InvertBinaryTree
```

---

## Repository Structure
```
leetcode-tree-problems/
├── .gitignore
├── README.md
├── GITHUB_SETUP.md (this file)
├── TREE_COMPLETE.md
├── solutions/
│   └── java/
│       ├── TreeNode.java
│       ├── InvertBinaryTree.java
│       ├── [18 more solutions...]
│       └── README.md
└── [documentation files]
```

---

## Need Help?

For Git documentation: https://git-scm.com/doc
For GitHub help: https://docs.github.com/en
