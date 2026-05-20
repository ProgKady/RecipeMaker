@echo off
echo ========================================
echo          Git Push Only - Kadysoft
echo ========================================

cd /d "C:\Users\ahmed.elkady\Documents\NetBeansProjects\RecipeMaker"

echo.
echo جاري التحضير...

:: التأكد من الـ branch
git checkout master >nul 2>&1

:: إضافة كل التعديلات
git add .

:: التحقق لو مفيش تغييرات
git diff --cached --quiet
if %errorlevel% == 0 (
    echo.
    echo ✅ لا يوجد تغييرات جديدة للرفع
    pause
    exit /b
)

:: عمل Commit
echo.
echo جاري الـ Commit...
git commit -m "Auto Update - %date% %time%"

:: Push
echo.
echo جاري الـ Push إلى GitHub...
git push origin master

if %errorlevel% neq 0 (
    echo.
    echo ⚠️ Push فشل.. جاري محاولة Force Push...
    git push origin master --force-with-lease
)

echo.
echo ========================================
echo ✅ تم الانتهاء بنجاح!
echo ========================================
pause