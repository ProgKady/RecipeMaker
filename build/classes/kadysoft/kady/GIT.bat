cd C:\Users\Ahmed.ElKady\Documents\NetBeansProjects\RecipeMaker

git checkout master || exit /b

git pull --rebase origin master || exit /b

git add .

git diff --cached --quiet && echo "No changes" && exit /b

git commit -m "Auto update"

git push origin master