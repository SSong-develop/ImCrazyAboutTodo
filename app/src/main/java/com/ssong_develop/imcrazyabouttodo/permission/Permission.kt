package com.ssong_develop.imcrazyabouttodo.permission

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState

// TODO : 내용은 좀 더 채워서, 뭐..어차피 카메라만 있으면 되긴 합니다.
@ExperimentalPermissionsApi
@Composable
fun Permission(
    permission: String = android.Manifest.permission.CAMERA,
    rationale: String = "앱을 사용하는데 카메라 권한이 필수입니다.",
    content : @Composable () -> Unit
) {
    val permissionState = rememberPermissionState(permission = permission)

    when(permissionState.status) {
        PermissionStatus.Granted -> {
            content()
        }
        is PermissionStatus.Denied -> {
            Rationale(
                text = rationale,
                onRequestPermission = { permissionState.launchPermissionRequest() }
            )
        }
    }
}

@Composable
private fun Rationale(
    text: String,
    onRequestPermission: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { /** no - op **/ },
        title = {
            Text(text = "Permission Request")
        },
        text = {
            Text(text)
        },
        confirmButton = {
            Button(onClick = onRequestPermission) {
                Text("OK")
            }
        }
    )
}