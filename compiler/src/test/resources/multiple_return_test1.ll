declare i32 @printf(i8*, ...)
@.str_1 = private unnamed_addr constant [6 x i8] c"this\0A\00"

define i32 @main() {
%1 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([6 x i8], [6 x i8]* @.str_1, i64 0, i64 0))
%2 = trunc i32 0 to i1
br i1 %2, label %if1true, label %if1false

if1true:
ret i32 0
br label %if1end

if1false:
ret i32 1
br label %if1end

if1end:
ret i32 0
}
