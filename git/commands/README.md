# Commands Cheat Sheet

## Branch
- To create and switch to new branch,
  ```
  git checkout -b <new-branch-name>
  ```

- To rename branch,
  ```
  git branch -m "<another-new-branch-name>"
  ```

## Commit
- To change last commit (i.e. commit message or add more code changes),
  ```
  git commit --ammend
  ```

- To throw away local commit,
  ```
  git reset --hard origin/<branch-name>
  ```

## Log
- To display log beautifully (A DOG),
  ```
  git log --all --decorate --oneline --graph
  ```

- You can alias the above command something like this,
  ```
  git config --global alias.prettylog 'log --all --decorate --oneline --graph'
  ```
  Then, use `prettylog` easily like this,
  ```
  git prettylog
  ```
  
## Merging
- To merge,
  ```
  git merge origin/<source-branch>
  ```
  
- To accept all incoming changes from source branch,
  ```
  git merge origin/<source-branch> --strategy-option theirs
  ```

- To accept all current changes and ignore incoming changes from source branch,
  ```
  git merge origin/<source-branch> --strategy-option ours
  ```

## Stash
- To stash changes,
  ```
  git stash -m "WIP: Implementation for big feature"
  ```
  
- To show all stashes
  ```
  git stash list
  ```

- To show stashed changes
  ```
  git stash show -p <stash-id>
  ```
  
## Squash
- To squash number of commits
  ```
  git rebase -i HEAD~N
  ```

  `N` is the number of commits to be squashed.