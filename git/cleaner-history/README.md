# Cleaner Git History
Cherry-picking is one of the ways the team is promoting commits from one environment branch (e.g. dev branch) to another higher branch (e.g. prod branch). One challenge that is being encountered when doing this is the presence of merge commits. There might be a better work around this without resorting to rebasing but this is what I've read and tried working effectively in the team so far. The beauty of the following approach is it also keeps the history clean.

The scenario is simple: you're done working on a feature branch, and you will initiate pull request to dev branch. And you made several commits in the feature branch.

1. The first ultimate rule: DO NOT PUSH OR PUBLISH YOUR FEATURE BRANCH TO REMOTE REPOSITORY IF YOU'RE NOT FINISHED YET APPLYING THE NEEDED CHANGES.


2. To update feature branch with changes from dev branch and to squash the commits on feature branch, use `git rebase -i origin/dev`. A prompt something like the following will show up (they are the commits made on your feature branch):
    ```
    pick abcd1234 commit message #1 for feature
    pick abcd1235 commit message #2 for feature
    pick abcd1236 commit message #3 for feature
    ```
   
3. For first commit use `pick`. For succeeding commits use `squash`.
    ```
    pick abcd1234 commit message #1 for feature
    squash abcd1235 commit message #2 for feature
    squash abcd1236 commit message #3 for feature
    ```
   
    Notes:
    - To edit, press `i`.
    - To save, press `Esc`, then type `:wq!` and hit `Enter`. 
    - You may need to manually resolve conflicts if you encountered them.


4. You will then be asked to create a commit message for the squashed commits. As what responsible developer would do, create a descriptive commit message. 
    ```
    Implement some feature
   
    The following are the changes:
    - Removed dead codes.
    - Refactored implementation to follow SOLID principles.
    - Added new components to incorporate the new feature. 
    ```
   Notes:
    - To edit, press `i`.
    - To save, press `Esc`, then type `:wq!` and hit `Enter`. 


5. The feature branch is now rebased and has all the updates from dev branch. You may now push and publish it to remote repository and initiate pull request. 

    Note, when there are change requests from code reviews, try the following steps:
    - Implement necessary changes based on code reviews.
    - Use `git commit --ammend` command to update the last commit.
    - Use `git push --force origin <feature-branch>` command to push changes to the remote repository and update the pull request.


6. Then, once the feature branch is ready to be merged back to dev branch (i.e. code review is done), depending on the tool, find and use an option that uses `Rebase and fast-forward` as `Merge Type`.


7. If these newly merged feature changes are needed to be promoted to branch dedicated for higher environment deployment like prod branch, you can just easily `cherry-pick` the specific single commit for that feature.