cd C:\Users\Ahmed.ElKady\Documents\NetBeansProjects\RecipeMaker

git checkout master

git pull --rebase origin master

git add .

git diff --cached --quiet || git commit -m "Auto update $(date)"

git push origin master