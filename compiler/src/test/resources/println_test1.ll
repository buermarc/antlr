declare i32 @printf(i8*, ...)
@.str_1 = private unnamed_addr constant [13 x i8] c"Hello World\0A\00"
@.str_2 = private unnamed_addr constant [14 x i8] c"Hello World\0A\0A\00"
@.str_3 = private unnamed_addr constant [15 x i8] c"Hello\0A World\0A\0A\00"

define i32 @main() {
%1 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([13 x i8], [13 x i8]* @.str_1, i64 0, i64 0))
%2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([14 x i8], [14 x i8]* @.str_2, i64 0, i64 0))
%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([15 x i8], [15 x i8]* @.str_3, i64 0, i64 0))
ret i32 0
}
