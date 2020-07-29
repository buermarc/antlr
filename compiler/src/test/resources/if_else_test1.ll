declare i32 @printf(i8*, ...)
@.str_1 = private unnamed_addr constant [6 x i8] c"TRUE\0A\00"
@.str_2 = private unnamed_addr constant [7 x i8] c"FALSE\0A\00"
@.str_3 = private unnamed_addr constant [8 x i8] c"ALWAYS\0A\00"
@.str_4 = private unnamed_addr constant [8 x i8] c"ALWAYS\0A\00"

define i32 @main() {
%1 = add i32 0, 1
%2 = trunc i32 %1 to i1
br i1 %2, label %if1true, label %if1false

if1true:
%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([6 x i8], [6 x i8]* @.str_1, i64 0, i64 0))
br label %if1end

if1false:
%4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([7 x i8], [7 x i8]* @.str_2, i64 0, i64 0))
%5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([8 x i8], [8 x i8]* @.str_3, i64 0, i64 0))
br label %if1end

if1end:
%6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([8 x i8], [8 x i8]* @.str_4, i64 0, i64 0))
ret i32 0
}
